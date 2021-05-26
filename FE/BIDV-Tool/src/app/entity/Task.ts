import { Operation } from "./Operation";
import { User } from "./User";

export class Task {
    id: number;
    description: string;
    assigneeId: number;
    assignee: User;
    operationId: number;
    operation: Operation;
    mappingSheet: string;
    openDate: string;
    dueDate: string;
    closeDate: string; 
    status: string;
}