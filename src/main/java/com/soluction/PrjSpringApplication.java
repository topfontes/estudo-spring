package com.soluction;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.springframework.amqp.core.Binding;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;

import com.soluction.CategoriaRepositorie.CategoriaRepositorie;
import com.soluction.CategoriaRepositorie.CidadeRepositorie;
import com.soluction.CategoriaRepositorie.ClienteRepositorie;
import com.soluction.CategoriaRepositorie.EnderecoRepositorie;
import com.soluction.CategoriaRepositorie.EstadoRepositorie;
import com.soluction.CategoriaRepositorie.ProdutoRepositorie;
import com.soluction.model.Categoria;
import com.soluction.model.Cidade;
import com.soluction.model.Cliente;
import com.soluction.model.Endereco;
import com.soluction.model.Estado;
import com.soluction.model.Produto;
import com.soluction.model.TipoCliente;
import br.com.mq.Recever;

@SpringBootApplication
public class PrjSpringApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepositorie categoriaRepositorie;

	@Autowired
	private ProdutoRepositorie produtoRepositorie;

	@Autowired
	private CidadeRepositorie cidadeRepositorie;

	@Autowired
	private EstadoRepositorie estadoRepositorie;

	@Autowired
	private ClienteRepositorie clienteRepositorie;

	@Autowired
	private EnderecoRepositorie enderecoRepositorie;

	// @Value("${rabbitmq.exchange}")
	static String topicExchangeName = "FILADAPUTAEXCHANGES";

	// @Value("${rabbitmq.routingkey}")
	static String routingkey = "ROUTINGKEY";

	// @Value("${rabbitmq.queue.name}")
	static String queueName = "FILADAPUTA";

	@Bean
	Queue queue() {
		return new Queue(queueName, false);
	}

	@Bean
	TopicExchange exchange() {
		return new TopicExchange(topicExchangeName);
	}

	@Bean
	Binding binding(Queue queue, TopicExchange exchange) {
		Binding b = BindingBuilder.bind(queue).to(exchange).with(routingkey);
		System.out.println("passou");
		return b;
	}

	@Bean
	SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
			MessageListenerAdapter listenerAdapter) {
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		container.setQueueNames(queueName);
		container.setMessageListener(listenerAdapter);
		return container;
	}

	@Bean
	MessageListenerAdapter listenerAdapter(Recever listener) {
		return new MessageListenerAdapter(listener, "LoadMessage");
	}

	public static void main(String[] args) {
		SpringApplication.run(PrjSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");

		Produto p1 = new Produto(null, "Computado", new Double(2000));
		Produto p2 = new Produto(null, "Impressora", new Double(800));
		Produto p3 = new Produto(null, "Mouse", new Double(80));

		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));

		categoriaRepositorie.saveAll(Arrays.asList(cat1, cat2));
		produtoRepositorie.saveAll(Arrays.asList(p1, p2, p3));

		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "Sao Paulo");

		Cidade c1 = new Cidade(null, "Uberlandia", est1);
		Cidade c2 = new Cidade(null, "USão Paulo", est2);
		Cidade c3 = new Cidade(null, "Uberlandia", est2);

		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));

		estadoRepositorie.saveAll(Arrays.asList(est1, est2));
		cidadeRepositorie.saveAll(Arrays.asList(c1, c2, c3));

		Cliente cli1 = new Cliente(null, "Marcos", "topfontes", "91136830553", TipoCliente.PESSOA_FISICA);
		cli1.getTelefones().addAll(Arrays.asList("79999710710", "7999987777"));

		Endereco e1 = new Endereco(null, "rua e1", "1", "cpl", "59999992", cli1, c1);
		Endereco e2 = new Endereco(null, "rua e2", "2", "cpl", "59999992", cli1, c2);

		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));

		clienteRepositorie.saveAll(Arrays.asList(cli1));
		enderecoRepositorie.saveAll(Arrays.asList(e1, e2));

	}

	public Categoria getCategoria(Long id) {
		Optional<Categoria> model = categoriaRepositorie.findById(id);
		return model.orElse(null);
	}

	public Produto getProduto(Long id) {
		Optional<Produto> model = produtoRepositorie.findById(id);
		return model.orElse(null);
	}

	public Cidade getCidade(Integer id) {
		Optional<Cidade> model = cidadeRepositorie.findById(id);
		return model.orElse(null);
	}

}
