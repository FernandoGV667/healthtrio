import lombok.Data;

@Data
public class MeasuredData {
  private String region;
  private String region_code;
  private int period;
  private float pct_md_pa_np_mu_aiu;
  private float pct_md_pa_np_mu;
  private float pct_md_mu_aiu;
  private float pct_md_mu;
  private float pct_np_mu_aiu;
  private float pct_np_mu;
  private float pct_pa_mu_aiu;
  private float pct_pa_mu;
  private float pct_hospitals_mu_aiu;
  private float pct_hospitals_mu;
  private float pct_cah_small_rural_mu_aiu;
  private float pct_cah_small_rural_mu;

  @Override
  public String toString() {
    return String.format("%-27s %s", region + '(' + region_code + ')', pct_hospitals_mu * 100);
  }
}
