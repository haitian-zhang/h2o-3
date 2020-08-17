package hex;

import hex.genmodel.utils.DistributionFamily;
import water.IcedUtils;
import water.MRTask;
import water.exceptions.H2OIllegalArgumentException;
import water.fvec.Chunk;
import water.fvec.Frame;
import water.fvec.NewChunk;
import water.fvec.Vec;
import water.util.ArrayUtils;
import water.util.MathUtils;

public class ModelMetricsRegressionCoxPH extends ModelMetricsRegression {

  private double _concordance;

  public double concordance() { return _concordance; }

  public ModelMetricsRegressionCoxPH(Model model, Frame frame, long nobs, double mse, double sigma, double mae, 
                                     double rmsle, double meanResidualDeviance, CustomMetric customMetric, 
                                     double concordance) {
    super(model, frame, nobs, mse, sigma, mae, rmsle, meanResidualDeviance, customMetric);
    
    this._concordance = concordance;
  }

  public static ModelMetricsRegressionCoxPH getFromDKV(Model model, Frame frame) {
    ModelMetrics mm = ModelMetrics.getFromDKV(model, frame);

    if (! (mm instanceof ModelMetricsRegressionCoxPH))
      throw new H2OIllegalArgumentException("Expected to find a Regression ModelMetrics for model: " + model._key.toString() + " and frame: " + frame._key.toString(),
              "Expected to find a ModelMetricsRegression for model: " + model._key.toString() + " and frame: " + frame._key.toString() + " but found a: " + mm.getClass());

    return (ModelMetricsRegressionCoxPH) mm;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(super.toString());
    
    if(!Double.isNaN(_concordance)) {
      sb.append(" concordance: " + (float) _concordance + "\n");
    } else {
      sb.append(" concordance: N/A\n");
    }
    
    return sb.toString();
  }

  static public ModelMetricsRegressionCoxPH make(Vec predicted, Vec actual, DistributionFamily family) {
    return make(predicted, actual, null, family);
  }

  /**
   * Build a Regression ModelMetrics object from predicted and actual targets
   * @param predicted A Vec containing predicted values
   * @param actual A Vec containing the actual target values
   * @param weights A Vec containing the observation weights (optional) 
   * @return ModelMetrics object
   */
  static public ModelMetricsRegressionCoxPH make(Vec predicted, Vec actual, Vec weights, DistributionFamily family) {
    if (predicted == null || actual == null)
      throw new IllegalArgumentException("Missing actual or predicted targets for regression metrics!");
    if (!predicted.isNumeric())
      throw new IllegalArgumentException("Predicted values must be numeric for regression metrics.");
    if (!actual.isNumeric())
      throw new IllegalArgumentException("Actual values must be numeric for regression metrics.");
    if (family == DistributionFamily.quantile || family == DistributionFamily.tweedie || family == DistributionFamily.huber)
      throw new IllegalArgumentException("Unsupported distribution family, requires additional parameters which cannot be specified right now.");
    Frame fr = new Frame(predicted);
    fr.add("actual", actual);
    if (weights != null) {
      fr.add("weights", weights);
    }
    family = family ==null ? DistributionFamily.gaussian : family;

    System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

//    return null;
    throw new UnsupportedOperationException();
  }




  public static class MetricBuilderRegressionCoxPH<T extends MetricBuilderRegressionCoxPH<T>> extends MetricBuilderRegression<T> {

    // Having computed a MetricBuilder, this method fills in a ModelMetrics
    public ModelMetricsRegressionCoxPH makeModelMetrics(Model m, Frame f, Frame adaptedFrame, Frame preds) {
      final ModelMetricsRegression modelMetricsRegression = super.makeModelMetrics(m, f, adaptedFrame, preds);
      
      double concordance = 0.123454321;

      System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
      System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
      System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
      System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
      System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
      System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
      System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
      System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
      System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
      System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
      System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
      System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
      
      ModelMetricsRegressionCoxPH mm = new ModelMetricsRegressionCoxPH(m, f, _count, modelMetricsRegression.mse(), 
              weightedSigma(), modelMetricsRegression.mae() , modelMetricsRegression.rmsle(), modelMetricsRegression.mean_residual_deviance(),
              _customMetric, concordance);
      
      if (m!=null) m.addModelMetrics(mm);
      return mm;
    }
  }

}
