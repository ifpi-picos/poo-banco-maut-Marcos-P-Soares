package notificacoes;

public class NotificacaoSMS implements Notificacao{

    @Override
    public void enviaNotificacao(String tipo, double valor) {
        System.out.println("enviando notificacao por SMS, "+ tipo + ", Valor: "+ valor);
    }
}