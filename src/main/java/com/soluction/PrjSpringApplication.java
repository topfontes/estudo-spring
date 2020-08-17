package com.soluction;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.soluction.CategoriaRepositorie.CategoriaRepositorie;
import com.soluction.CategoriaRepositorie.CidadeRepositorie;
import com.soluction.CategoriaRepositorie.ClienteRepositorie;
import com.soluction.CategoriaRepositorie.EnderecoRepositorie;
import com.soluction.CategoriaRepositorie.EstadoRepositorie;
import com.soluction.CategoriaRepositorie.ProdutoRepositorie;
import com.soluction.model.Categoria;

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

    @Bean
    public WebMvcConfigurer corsConfigure() {
        return new WebMvcConfigurer() {

            /**
             * Habilita o CORS para todos as URLs.
             */
            @Override
            public void addCorsMappings(final CorsRegistry registry) {
                registry.addMapping("/**").allowedMethods("GET", "POST", "PUT", "PATH", "DELETE");
            }
        };
    }

    public static void main(final String[] args) {
        SpringApplication.run(PrjSpringApplication.class, args);

    }

    @Override
    public void run(final String... args) throws Exception {

        String in = "insert into taxi.ide_identificador(ide_tx_identificador,ide_dt_criacao) values (";
        Random r = new Random(1932892);

        for (int i = 0; i < 200; i++) {
            String s = in;
            s += "'" + r.nextInt(9999) + "','2020-07-14');";
            System.out.println(s);
        }

        Categoria cat1 = new Categoria(null, "Informática");
        // Categoria cat2 = new Categoria(null, "Escritório");
        //
        // Produto p1 = new Produto(null, "Computado", new Double(2000));
        // Produto p2 = new Produto(null, "Impressora", new Double(800));
        // Produto p3 = new Produto(null, "Mouse", new Double(80));
        //
        // cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
        // cat2.getProdutos().addAll(Arrays.asList(p2));
        //
        // p1.getCategorias().addAll(Arrays.asList(cat1));
        // p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
        // p3.getCategorias().addAll(Arrays.asList(cat1));
        //
        // categoriaRepositorie.saveAll(Arrays.asList(cat1, cat2));
        // produtoRepositorie.saveAll(Arrays.asList(p1, p2, p3));
        //
        // Estado est1 = new Estado(null, "Minas Gerais");
        // Estado est2 = new Estado(null, "Sao Paulo");
        //
        // Cidade c1 = new Cidade(null, "Uberlandia", est1);
        // Cidade c2 = new Cidade(null, "USão Paulo", est2);
        // Cidade c3 = new Cidade(null, "Uberlandia", est2);
        //
        // est1.getCidades().addAll(Arrays.asList(c1));
        // est2.getCidades().addAll(Arrays.asList(c2, c3));
        //
        // estadoRepositorie.saveAll(Arrays.asList(est1, est2));
        // cidadeRepositorie.saveAll(Arrays.asList(c1, c2, c3));
        //
        // Cliente cli1 = new Cliente(null, "Marcos", "topfontes", "91136830553",
        // TipoCliente.PESSOA_FISICA);
        // cli1.getTelefones().addAll(Arrays.asList("79999710710", "7999987777"));
        //
        // Endereco e1 = new Endereco(null, "rua e1", "1", "cpl", "59999992", cli1, c1);
        // Endereco e2 = new Endereco(null, "rua e2", "2", "cpl", "59999992", cli1, c2);
        //
        // cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
        //
        // clienteRepositorie.saveAll(Arrays.asList(cli1));
        // enderecoRepositorie.saveAll(Arrays.asList(e1, e2));

        // File fi = new File("marcos-texts");
        // boolean f = fi.mkdir();
        //
        // BigDecimal resultado = new BigDecimal(5.20);
        //
        // float fracao = resultado.floatValue() % 1.0f;
        // if (fracao == 0.0f) {
        // resultado = new BigDecimal(resultado.intValue());
        // System.out.println("integer " + resultado);
        // } else {
        // BigDecimal bF = new BigDecimal(fracao);
        // bF = bF.setScale(2, BigDecimal.ROUND_HALF_EVEN);
        // if (bF.floatValue() % 0.10f != 0f) {
        // resultado = resultado.setScale(2, BigDecimal.ROUND_HALF_EVEN);
        // } else {
        // resultado = resultado.setScale(1, BigDecimal.ROUND_HALF_EVEN);
        // }
        // System.out.println("Decimal " + resultado);
        // }
        //
        // TesteXml testeXml = new TesteXml(1, "abc");
        // TesteChidren t = new TesteChidren(1, "filho");
        // testeXml.setChildren(t);
        //
        // XmlMapper mapper = new XmlMapper();
        // String file = mapper.writeValueAsString(testeXml);
        // System.out.println(file);
        //
        // Origem o = new Origem("Marcos", "UUUU", "");
        //
        // Destino d = new Destino();
        // Util util = new Util();
        // util.setUpdateValue(o, d);
        // String a = "a";

    }

    class Util {
        public void setUpdateValue(final Object objO, final Object objD)
                throws IllegalAccessException, IllegalArgumentException, InvocationTargetException,
                NoSuchMethodException, SecurityException {

            for (Method set : objD.getClass().getMethods()) {
                if (set.getName().startsWith("set")) {
                    Class[] clazz = set.getParameterTypes();
                    String field = set.getName().substring(3, set.getName().length());
                    System.out.println(field);
                    String metodo = "get".concat(field);
                    Method get = objO.getClass().getMethod(metodo);
                    if (get != null && !set.isAnnotationPresent(javax.persistence.Id.class)) {
                        // set.invoke(objD, get.invoke(objO));
                        set.invoke(objD);

                    }
                }
            }
        }
    }

    class Origem {

        // int id;
        //
        // public int getId() {
        // return id;
        // }
        //
        // public void setId(final int id) {
        // this.id = id;
        // }

        private String nome;
        private String cpf;
        private String testeNull;

        public Origem(final String nome, final String cpf, final String testeNull) {
            super();
            this.nome = nome;
            this.cpf = cpf;
            this.testeNull = testeNull;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(final String nome) {
            this.nome = nome;
        }

        public String getCpf() {
            return cpf;
        }

        public void setCpf(final String cpf) {
            this.cpf = cpf;
        }

        public String getTesteNull() {
            return testeNull;
        }

        public void setTesteNull(final String testeNull) {
            this.testeNull = testeNull;
        }

    }

    class Destino {
        private String nome;
        private String cpf;
        private String testeNull;

        // int id;
        //
        // @Id
        // public int getId() {
        // return id;
        // }
        //
        // public void setId(final int id) {
        // this.id = id;
        // }

        public String getNome() {
            return nome;
        }

        public void setNome(final String nome) {
            this.nome = nome;
        }

        public String getCpf() {
            return cpf;
        }

        public void setCpf(final String cpf) {
            this.cpf = cpf;
        }

        public String getTesteNull() {
            return testeNull;
        }

        public void setTesteNull(final String testeNull) {
            this.testeNull = testeNull;
        }

    }

}
