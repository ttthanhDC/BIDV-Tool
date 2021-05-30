import { Component, NgZone, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { AppByService } from 'src/app/entity/AppByService';
import { Chart } from 'src/app/entity/Chart';
import { DashboardResponse } from 'src/app/entity/DashBoardResponse';
import { DashboardService } from 'src/app/services/dashboard/dashboard.service';
import { UploadfileService } from 'src/app/services/uploadfile/uploadfile.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  file: File;
  formf = new FormGroup({
    file: new FormControl('', [Validators.required])
  });
  dataSource: any;
  dataGetAppByService: any;
  dataOperation: any;
  dataOprByService: any;
  dataGetServiceByApp: any;
  dataGetServiceByStatus: any;
  dataTask: any;
  selectedSlice = 'none';
  chart: any;
  chartResponse: Chart = new Chart();
  totalApp: DashboardResponse[];
  appByService: AppByService[]
  constructor(private uploadFileService: UploadfileService,
    private dashBoardService: DashboardService,
    private zone: NgZone) {
    // Pie data
    this.dataSource = {
      chart: {
        caption: "Get Total Application",
        plottooltext: "<b>$value</b> Application $label",
        showLegend: "1",
        showPercentValues: "1",
        legendPosition: "bottom",
        useDataPlotColorForLabels: "1",
        enablemultislicing: "0",
        showlegend: "0",
        theme: "fusion",
      },
      data: []
    }
    this.dashBoardService.getTotalApp().subscribe(res => {
      this.totalApp = res;
      this.dataSource.data = this.totalApp;
    });

    // chart data get App by service
    this.dataGetAppByService = {
      chart: {
        caption: "Get Application By Service",
        xaxisname: "Service",
        yaxisname: "Total Application",
        showvalues: "1",
        labeldisplay: "WRAP",
        linethickness: "3",
        numVisiblePlot: "12",
        scrollheight: "10",
        flatScrollBars: "1",
        scrollShowButtons: "0",
        scrollColor: "#cccccc",
        theme: "fusion"
      },
      // Chart Data - from step 2
      categories: [],
      dataset: []
      
    };
    this.dashBoardService.getAppByServiceDemo().subscribe(res => {
      this.chartResponse = res;
      this.dataGetAppByService.categories = this.chartResponse.categories;
      this.dataGetAppByService.dataset = this.chartResponse.dataset;
    });

    // Pie Operation By Status
    this.dataOperation = {
      chart: {
        caption: "Get Operation By Status",
        plottooltext: "Status $label has <b>$value</b> Operation",
        showLegend: "1",
        showPercentValues: "1",
        legendPosition: "bottom",
        useDataPlotColorForLabels: "1",
        enablemultislicing: "0",
        showlegend: "0",
        theme: "fusion",
      },
      data: []
    }
    this.dashBoardService.getOperationByStatus().subscribe(res => {
      this.totalApp = res;
      this.dataOperation.data = this.totalApp;
    });

    // chart data get Operation by service
    this.dataOprByService = {
      chart: {
        caption: "Get Operation By Service",
        xAxisName: "Total Operation",
        yAxisName: "Service",
        showvalues: "1",
        labeldisplay: "WRAP",
        linethickness: "3",
        numVisiblePlot: "12",
        scrollheight: "10",
        flatScrollBars: "1",
        scrollShowButtons: "0",
        scrollColor: "#cccccc",
        theme: "fusion"
      },
      // Chart Data - from step 2
      categories: [],
      dataset: []
    };
    this.dashBoardService.getOperationByService().subscribe(res => {
      this.chartResponse = res;
      this.dataOprByService.categories = this.chartResponse.categories;
      this.dataOprByService.dataset = this.chartResponse.dataset;
    });


    // chart data get Service by App
    this.dataGetServiceByApp = {
      chart: {
        caption: "Get Service By Application",
        xAxisName: "Application",
        yAxisName: "Total Service",
        showvalues: "1",
        labeldisplay: "WRAP",
        linethickness: "3",
        numVisiblePlot: "12",
        scrollheight: "10",
        flatScrollBars: "1",
        scrollShowButtons: "0",
        scrollColor: "#cccccc",
        theme: "fusion"
      },
      // Chart Data - from step 2
      categories: [],
      dataset: []
    };
    this.dashBoardService.getServiceByApp().subscribe(res => {
      this.chartResponse = res;
      this.dataGetServiceByApp.categories = this.chartResponse.categories;
      this.dataGetServiceByApp.dataset = this.chartResponse.dataset;
    });

    // Pie Service By Status
    this.dataGetServiceByStatus = {
      chart: {
        caption: "Get Service By Status",
        plottooltext: "Status $label has <b>$value</b> Service",
        showLegend: "1",
        showPercentValues: "1",
        legendPosition: "bottom",
        useDataPlotColorForLabels: "1",
        enablemultislicing: "0",
        showlegend: "0",
        theme: "fusion",
      },
      data: []
    }
    this.dashBoardService.getServiceByStatus().subscribe(res => {
      this.totalApp = res;
      this.dataGetServiceByStatus.data = this.totalApp;
    });

    // chart data get total Task by Operation
    this.dataTask = {
      chart: {
        caption: "Get Task By Operation",
        xAxisName: "Application-Service-Operation",
        yAxisName: "Total Task",
        showvalues: "1",
        labeldisplay: "WRAP",
        linethickness: "3",
        numVisiblePlot: "12",
        scrollheight: "10",
        flatScrollBars: "1",
        scrollShowButtons: "0",
        scrollColor: "#cccccc",
        theme: "fusion"
      },
      // Chart Data - from step 2
      categories: [],
      dataset: []
    };
    this.dashBoardService.getTaskByOperation().subscribe(res => {
      this.chartResponse = res;
      this.dataTask.categories = this.chartResponse.categories;
      this.dataTask.dataset = this.chartResponse.dataset;
    });

  }

  ngOnInit(): void {
  }
  get f() { return this.formf.controls; }
  submitForm() {
    // this.uploadFileService.uploadFileExcel(this.file).subscribe(data =>{
    //   this.response = data;
    //   console.log('success 11');

    // })
  }
  changeFile(event: any) {
    this.file = event.target.files[0];
  }
  initialized($event: any) {
    this.chart = $event.chart; // saving chart instance
  }

  // Change listener for radio buttons
  onRadioOptionChange(option: any) {
    this.selectedSlice = option;
    console.log(option);

    // For each data element , see if it is selected, if none then slice in all elements
    this.dataSource.data.forEach((d: any, index: any) => {
      if (option == 'none') {
        this.chart.slicePlotItem(index, false);
      } else if (option === d.label.toLowerCase()) {
        console.log(d.label.toLowerCase());

        this.chart.slicePlotItem(index, true);
      }
    });
  }

  // Get data item label
  getLabel(index: any) {
    return this.dataSource.data[index].label;
  }

  // FusionCharts Component dataPlot click listener
  dataplotClick($event: any) {
    let dataIndex = $event.dataObj.dataIndex;
    let isSliced = $event.dataObj.isSliced;
    this.zone.run(() => {
      this.selectedSlice = isSliced ? 'none' : this.getLabel(dataIndex).toLowerCase();
    })
  }
}
