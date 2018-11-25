package com.tdat.gui.reports;

import com.tdat.app.App;
import com.tdat.gui.reports.AddChartWindow;
import com.tdat.report.chart.ChartScheme;
import com.tdat.report.chart.ChartType;
import com.tdat.report.chart.TrendChartScheme;

public class AddTrendReport extends AddChartWindow {

    public AddTrendReport() {
        super("Trend");
    }

    @Override
    public ChartScheme addReport(String reportTitle, String xAxis, String yAxis, String column, ChartType chartType) {
        ChartScheme chartScheme = new TrendChartScheme(column, chartType);

        chartScheme.setMainTitle(reportTitle);
        chartScheme.setXTitle(xAxis);
        chartScheme.setYTitle(yAxis);

        App.reportsList.add(chartScheme);
        return chartScheme;
    }

}
