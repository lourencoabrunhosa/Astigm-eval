package Graphics;


import javafx.scene.chart.*;

public class barchart{
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static BarChart<String,Number> barChartV(double[][] data) {
		final CategoryAxis xAxis = new CategoryAxis();
		final NumberAxis yAxis = new NumberAxis();
		final BarChart<String,Number> bc = new BarChart<String,Number>(xAxis,yAxis);
		
		bc.setTitle("Pre-surgery Vs. Post-surgery Astigmatism");
		
		xAxis.setLabel("Cylindric power [D]");
		yAxis.setLabel("Ocurrences [%]");
		
		XYChart.Series series1 = new XYChart.Series<>();
		series1.setName("pre");
		
		XYChart.Series series2 = new XYChart.Series<>();
		series2.setName("pos");
		
		double x=0;
		for(int i=0;i<data[0].length-1;i++) {
			series1.getData().add(new XYChart.Data<String,Number>(x+" - "+data[0][i],data[1][i]));
			series2.getData().add(new XYChart.Data<String,Number>(x+" - "+data[0][i],data[2][i]));
			x=data[0][i];
		}
		series1.getData().add(new XYChart.Data<String,Number>("> "+data[0][data[0].length-2],data[1][data[0].length-1]));
		series2.getData().add(new XYChart.Data<String,Number>("> "+data[0][data[0].length-2],data[2][data[0].length-1]));
		
		bc.getData().addAll(series1,series2);
		
		return bc;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static BarChart<Number,String> barChartH(double[][] data) {
		final CategoryAxis yAxis = new CategoryAxis();
		final NumberAxis xAxis = new NumberAxis();
		final BarChart<Number,String> bc = new BarChart<Number,String>(xAxis,yAxis);
		
		bc.setTitle("Angle of Error");
		
		xAxis.setLabel("Ocurrences [%]");
		yAxis.setLabel("Angle interval [°]");
		
		XYChart.Series series1 = new XYChart.Series<>();
		
		series1.getData().add(new XYChart.Data<Number,String>(data[1][0],"< "+data[0][0]));
		
		double x=data[0][0];
		for(int i=1;i<data[0].length-1;i++) {
			series1.getData().add(new XYChart.Data<Number,String>(data[1][i], x+" - "+data[0][i]));
			x=data[0][i];
		}
		series1.getData().add(new XYChart.Data<Number,String>(data[1][data[0].length-1],"> "+data[0][data[0].length-2]));

		bc.getData().addAll(series1);
		
		return bc;
	}
}
