package login;

public class main {

    public static void main(String[] args) {

        // criando um objeto da classe User (aquele que conecta no banco)
        User u = new User();

        // aqui eu só coloco um login e senha de teste
        // (tem que existir no seu banco, senão vai dar false)
        boolean resultado = u.verificarUsuario("admin", "123");

        // só pra mostrar o que voltou
        System.out.println("Resultado da verificação: " + resultado);

        // se deu certo, também mostro o nome que veio do banco
        if (resultado) {
            System.out.println("Nome do usuário encontrado: " + u.nome);
        } else {
            System.out.println("Nenhum usuário encontrado com essas credenciais.");
        }
    }
}
