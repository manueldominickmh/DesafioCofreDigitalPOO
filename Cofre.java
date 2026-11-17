public class Cofre {

    private int senha;
    private int capacidade = 1;
    private int contador;
    private int qntdItens;
    private boolean cofreAberto;
    private boolean cofreBloqueado;
    private String conteudoCofre;

    public Cofre(int senha) {

        this.senha = senha;
        this.cofreAberto = true;
        this.conteudoCofre = "";

    }

    public void cofre_aberto(int senhaDigitada) {

        if (cofreAberto) {

            System.out.println("O cofre já está aberto.");

        } else if (cofreBloqueado) {

            System.out.println("O cofre está bloqueado. Não é possível destrancar agora.");

        } else if (senhaDigitada == this.senha) {

            cofreAberto = true;
            contador = 0;

        } else {

            System.out.println("Senha incorreta.");
            contador++;

            if (contador >= 3) {

                cofreBloqueado = true;

            }

        }

    }

    public void guardar_item(String itemGuardado) {

        if (this.cofreAberto && (qntdItens < capacidade)) {

            System.out.println("Você guardou " + itemGuardado + " no cofre.");
            conteudoCofre = itemGuardado;
            qntdItens++;

        } else if (!cofreAberto) {

            System.out.println("Não é possível guardar o item. O cofre se encontra trancado ou bloqueado.");

        } else {

            System.out.println("Não é possível guardar o item. O cofre está cheio.");

        }

    }

    public void retirar_item() {

        if (this.cofreAberto && qntdItens > 0) {

            System.out.println("Você retirou " + conteudoCofre + " do cofre.");
            conteudoCofre = "";
            qntdItens--;

        } else if (!cofreAberto) {

            System.out.println("Não é possível retirar o item. O cofre está trancado.");

        } else {

            System.out.println("Não é possível retirar o item. O cofre está vazio.");

        }

    }

    public void trancar_cofre() {

        if (cofreAberto) {

            System.out.println("Cofre trancado com sucesso.");
            cofreAberto = false;

        } else {

            System.out.println("O cofre já está trancado ou bloqueado.");

        }

    }

    public String getConteudoCofre() {

        if (cofreAberto) {

            return conteudoCofre;

        } else {

            System.out.println("Não é possível visualizar o conteúdo. O cofre está trancado.");
            return null;

        }

    }

}