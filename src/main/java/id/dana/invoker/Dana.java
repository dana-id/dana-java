package id.dana.invoker;

import id.dana.invoker.auth.DanaAuth;
import id.dana.paymentgateway.v1.api.PaymentGatewayApi;
import id.dana.widget.v1.api.WidgetApi;
import okhttp3.OkHttpClient;

public class Dana {

  private static volatile Dana instance;

  private final PaymentGatewayApi paymentGatewayApi;

  private final WidgetApi widgetApi;

  private Dana() {
    OkHttpClient client = new OkHttpClient.Builder()
        .addInterceptor(new DanaAuth())
        .build();
    this.paymentGatewayApi = new PaymentGatewayApi(client);
    this.widgetApi = new WidgetApi(client);
  }

  public static Dana getInstance() {
    if (instance == null) {
      synchronized (Dana.class) {
        if (instance == null) {
          instance = new Dana();
        }
      }
    }
    return instance;
  }

  public PaymentGatewayApi getPaymentGatewayApi() {
    return paymentGatewayApi;
  }

  public WidgetApi getWidgetApi() {
    return widgetApi;
  }

}

