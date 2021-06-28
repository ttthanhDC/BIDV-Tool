import { Application } from "./Application";
import { Operation } from "./Operation";
import { ResOprByService } from "./ResOprByService";
import { ResServiceByApp } from "./ResServiceByApp";
import { Service } from "./Service";
import { User } from "./User";

export class OpenIssue {
    id: number;
    description: string;
    reporterId: number;
    reporter: User;
    resolution: string;
    operationId: number;
    owner: string;
    support:string;
    openDate: string;
    dueDate: string;
    closeDate: string;
    status: string;
    comment: string;
    jraNumber:string;
}