import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] personagens = {
                "Homem de Ferro",
                "Capitão América",
                "Thor",
                "Hulk",
                "Viuva Negra",
                "Gaviao Arqueiro",
                "Homem Formiga"
        };

        int quantidade = 7;
        char escolha;
        int erros = 0;

        System.out.println("Bem vindo ao jogo de adivinhação de personagens da Marvel!");
        System.out.println("Deseja adicionar um personagem? (s/n)");
        escolha = sc.next().charAt(0);
        if (escolha == 's') {
            System.out.println("Digite o nome do personagem:");
            personagens[quantidade] = sc.next();
            quantidade++;
        }
        //sorteio do Personagem
        int sorteio = (int) (Math.random() * quantidade);
        String personagem = personagens[sorteio];

        //mascara
        char[] mascara = new char[personagem.length()];
        for (int i = 0; i < personagem.length(); i++) {
            mascara[i] = '?';
        }

        int pontos = 0;
        int acertos = 0;
        char chute;

        while (erros < 6 && acertos < personagem.length()) {
            System.out.println("Personagem: ");
            for (int i = 0; i < personagem.length(); i++) {
                System.out.print(mascara[i]);
            }
            System.out.println("\nDigite uma letra: ");
            chute = sc.next().charAt(0);
            boolean acertou = false;

            for (int i = 0; i < personagem.length(); i++) {
                if (personagem.charAt(i) == chute) {
                    mascara[i] = chute;
                    acertos++;
                    acertou = true;
                }
            }
            if (acertou) {
                pontos += 2;
            } else {
                erros++;
                pontos--;
            }
            switch (erros) {
                case 0:
                    System.out.println("  _______");
                    System.out.println(" |    |");
                    break;
                case 1:
                    System.out.println(" O");
                    break;
                case 2:
                    System.out.println(" O ");
                    System.out.println(" |");
                    break;
                case 3:
                    System.out.println(" O");
                    System.out.println("/|");
                    break;
                case 4:
                    System.out.println(" O");
                    System.out.print("/|/");
                    break;
                case 5:
                    System.out.println("  O");
                    System.out.print("/ | /");
                    System.out.println(" /");
                    break;
                case 6:
                    System.out.println("  O");
                    System.out.print("/ | /");
                    System.out.println(" / /");
                    break;
            }
        }

        if (acertos == personagem.length()) {
            System.out.println("Parabéns! Você acertou o personagem " + personagem);
            System.out.println("Pontuação: " + pontos);
        } else if (erros == 6) {
            System.out.println("Você perdeu! O personagem era " + personagem);
            System.out.println("Pontuação: " + pontos);
        }
    }
}

