import { Operation } from "./Operation";
import { User } from "./User";

export class OpenIssue {
    id: number;
    description: string;
    reporterId: number;
    reporter: User;
    resolution: string;
    operationId: number;
    operation: Operation;
    owner: string;
    openDate: string;
    dueDate: string;
    closeDate: string;
    status: string;
    comment: string
}