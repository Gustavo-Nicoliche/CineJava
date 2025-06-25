public class Ingresso {
  protected double valor;
  protected String nomeFilme;
  protected boolean dublado;

  public Ingresso(double valor, String nomeFilme, boolean dublado) {
    this.valor = valor;
    this.nomeFilme = nomeFilme;
    this.dublado =dublado;
  }

  public double getValorReal() {
    return valor;
  }

  public String getDescricao() {
    return nomeFilme + (dublado ? " (Dublado)" : " (Legendado)");
  }
}
