package src.model;

public class CartaoCreditoStandard extends CartaoCredito {

    public CartaoCreditoStandard(String numero, double limite) {
        super(numero, limite);
    }

    @Override
    public void notificarCompra(double valor) {
        System.out.println("Compra de R$" + valor + " realizada com sucesso no Cartão Standard.");
    }
}
