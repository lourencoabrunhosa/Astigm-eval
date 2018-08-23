package Graphics;


import javafx.scene.chart.*;

public class barchart{
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static BarChart<String,Number> barChart() {
		final CategoryAxis xAxis = new CategoryAxis();
		final NumberAxis yAxis = new NumberAxis();
		final BarChart<String,Number> bc = new BarChart<String,Number>(xAxis,yAxis);
		
		bc.setTitle("Test");
		
		xAxis.setLabel("x");
		yAxis.setLabel("y");
		
		XYChart.Series series1 = new XYChart.Series<>();
		series1.setName("pre");
		
		series1.getData().add(new XYChart.Data<String,Number>("0-0.5",32));
		series1.getData().add(new XYChart.Data<String,Number>("0.5-1",64));
		series1.getData().add(new XYChart.Data<String,Number>("1-1.5",96));
		
		XYChart.Series series2 = new XYChart.Series<>();
		series2.setName("pos");
		
		series2.getData().add(new XYChart.Data<String,Number>("0-0.5",12));
		series2.getData().add(new XYChart.Data<String,Number>("0.5-1",24));
		series2.getData().add(new XYChart.Data<String,Number>("1-1.5",36));
		
		bc.getData().addAll(series1,series2);
		
		return bc;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static BarChart<Number,String> barChartH() {
		final CategoryAxis yAxis = new CategoryAxis();
		final NumberAxis xAxis = new NumberAxis();
		final BarChart<Number,String> bc = new BarChart<Number,String>(xAxis,yAxis);
		
		bc.setTitle("Test");
		
		xAxis.setLabel("x");
		yAxis.setLabel("y");
		
		XYChart.Series series1 = new XYChart.Series<>();
		series1.setName("pre");
		
		series1.getData().add(new XYChart.Data<Number,String>(32,"0-0.5"));
		series1.getData().add(new XYChart.Data<Number,String>(64,"0.5-1"));
		series1.getData().add(new XYChart.Data<Number,String>(96,"1-1.5"));
	
		
		bc.getData().addAll(series1);
		
		return bc;
	}
}
