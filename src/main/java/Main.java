import br.com.dio.desafio.dominio.Artigo;
import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Conteudo;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.data.NewDev;
import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Faker faker = new Faker();
        List<NewDev> devs = new ArrayList<>();
        List<Dev> devList = new ArrayList<>();

        int random = faker.number().numberBetween(1, 10);
        int random2 = faker.number().numberBetween(1, random/2);

        for (int i = 0; i < random; i++) {
            devs.add(addDev(faker));
        }

        for (NewDev dev : devs) {
            Dev newDev = new Dev();
            newDev.setNome(faker.name().fullName());
            for (Bootcamp bootcamp : dev.getBootcampList()) {
                newDev.inscreverBootcamp(bootcamp);
            }
            newDev.setArtigos(dev.getArtigoList());
            newDev.setCurriculo(dev.getCurriculo());
            newDev.setFormacao(dev.getFormacao());
            newDev.setExperiencia(dev.getExperiencia());
            devList.add(newDev);
        }

        for (Dev dev : devList) {
            System.out.println("Perfil de " + dev.getNome());

            for (int i = 0; i < random2; i++) {
               progredir(dev);
            }

            System.out.println("--x--x--x--x--x--x--x--x--x--");
            System.out.println("Conteúdos Inscritos: ");
            for(Conteudo conteudo : dev.getConteudosInscritos()){
                System.out.println(conteudo.getTitulo());
                System.out.println(conteudo.getDescricao());
                System.out.println("----");
            }
            System.out.println("Conteúdos Concluídos: ");
            for(Conteudo conteudo : dev.getConteudosConcluidos()){
                System.out.println(conteudo.getTitulo());
                System.out.println(conteudo.getDescricao());
                System.out.println("----");
            }
            System.out.println("XP:" + dev.calcularTotalXp());
            System.out.println("--x--x--x--x--x--x--x--x--x--");
            System.out.println("Conteúdo do(s) Artigo(s): ");
            for (Artigo artigo : dev.getArtigos()) {
                System.out.println("Título: " + artigo.getTitulo()+ "\n");
                System.out.println("Descrição: " + artigo.getConteudo()+ "\n");
                System.out.println("Data de Publicação: " + artigo.getDataInicial());
                System.out.println("----");
            }
            System.out.println("--x--x--x--x--x--x--x--x--x--");
            System.out.println("Currículo" + "\n" + dev.getCurriculo());
            System.out.println("Formação Acadêmica" + "\n" + dev.getFormacao());
            System.out.println("Experiência Profissional" + "\n" + dev.getExperiencia());
            System.out.println("-------");

        }

    }

    public static NewDev addDev(Faker faker) {
        NewDev info = new NewDev();
        int random = faker.number().numberBetween(0, 10);
        boolean isFinished = faker.bool().bool();
        LocalDate data = createDate();
        LocalDate dataFinal;

        if (isFinished) {
            dataFinal = data.plusDays(1460);
        } else {
            dataFinal = null;
        }

        for (int i = 0; i < random; i++) {
            info.createCurso(faker.programmingLanguage().name(), faker.programmingLanguage().creator(), faker.random().nextInt(1, 50));
            info.createMentoria(faker.programmingLanguage().name(), faker.programmingLanguage().creator());
            info.createArtigo(faker.gameOfThrones().dragon(), faker.gameOfThrones().quote());
        }

        info.bootcamp(faker.book().title(), faker.book().author(), info.getCursos(), info.getMentoriaList());
        info.createFormacaoAcademica(faker.university().name(), faker.funnyName().name(), faker.funnyName().name(),
                data, dataFinal);
        info.createExperienciaProfissional("Grupo GFT", "QA Jr", "Teste de software", LocalDate.of(2022, 10, 1));
        info.createCurriculo(faker.name().fullName(), faker.phoneNumber().cellPhone(), faker.internet().emailAddress(),
                faker.number().randomDouble(0, 1000, 100000));

        return info;
    }

    public static LocalDate createDate() {
        Faker faker = new Faker();

        int year = faker.number().numberBetween(2000, 2022);
        int month = faker.number().numberBetween(1, 12);
        int day;

        if (month == 2) {
            day = faker.number().numberBetween(1, 28);
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            day = faker.number().numberBetween(1, 30);
        } else {
            day = faker.number().numberBetween(1, 31);
        }

        return LocalDate.of(year, month, day);
    }

    public static void progredir(Dev dev) {
        Optional<Conteudo> conteudo = dev.getConteudosInscritos().stream().findFirst();
        if(conteudo.isPresent()) {
            dev.getConteudosConcluidos().add(conteudo.get());
            dev.getConteudosInscritos().remove(conteudo.get());
        } else {
            System.err.println("Você não está matriculado em nenhum conteúdo!");
        }
    }

}
