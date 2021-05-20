import { Service } from "./Service";

export class Operation {
    id :number;
    serviceId : number;
    service : Service;
    applicationId : number ;
    operationName : string ;
    interactWithCore : boolean;
    status : string;
    ssdSOA : string;
    ssdLegacy : string;
    workshop : boolean;

}