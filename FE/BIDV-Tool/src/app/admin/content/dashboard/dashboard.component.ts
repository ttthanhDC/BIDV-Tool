import { Component, NgZone, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
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
  selectedSlice = 'none';
  chart: any;
  totalApp: DashboardResponse[];
  constructor(private uploadFileService: UploadfileService,
    private dashBoardService: DashboardService,
    private zone: NgZone) {
    this.dataSource = {
      chart: {
        caption: "Get Total Application",
        plottooltext: "<b>$percentValue</b> in $label",
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

  }

  ngOnInit(): void {
    // setTimeout(() => {
    //   SelectedSingleton.change(this.sampleCode['ex24'].title);
    // })
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
    // For each data element , see if it is selected, if none then slice in all elements
    this.dataSource.data.forEach((d: any, index: any) => {
      if (option == 'none') {
        this.chart.slicePlotItem(index, false);
      } else if (option === d.label.toLowerCase()) {
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
