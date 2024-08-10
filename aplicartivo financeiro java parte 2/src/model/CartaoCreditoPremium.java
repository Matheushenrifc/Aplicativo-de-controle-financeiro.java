package src.model;

public class CartaoCreditoPremium extends CartaoCredito {

    public CartaoCreditoPremium(String numero, double limite) {
        super(numero, limite);
    }

    @Override
    public void notificarCompra(double valor) {
        System.out.println("Compra de R$" + valor + " realizada com sucesso no Cartão Premium.");
    }
}