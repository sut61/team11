import { Checks } from '../check/check.service';

export class Cart{
    cartId?: any;
    paymentStatus?: string;
    date?: Date;
    customer?: Customer;
    buyItems?: BuyItem[];
}
export class BuyItem{
    buyItemId?: any;
    itemName?: string;
    price?: any;
    amount?: number;
    totalPrice?: any;
    cart?: Cart;
    category?: Category;
    unit?: Unit;
}
export class Category{
    categoryId?: any;
    categoryName?: string;
}
export class Unit{
    unitId?: any;
    unitName?: string;
}
export class Customer{
    customerId?: any;
    customerName?: string;
    address?: string;
    tel?: any;
}
export class Employee{
    eid?: any;
    ename?: string;
}

export class SaleItem{
    saleItemId: any;
    itemName: string;
    price?: any;
    amount?: number;
    totalPrice?: any;
    date?: Date;
    customer: Customer = new Customer();
    saleItems: any;
}
export class Stock{
    stockId?: any;
    stockName?: string;
    description?: string;
}
export class Repairman{
    repairmanId?: any;
    repairmanName?: string;
}
export class UsedItem{
    usedItemId?: any;
    price?: any;
    details?: string;
    stock?: Stock;
    repairman?: Repairman;
    checks?: Checks;
}


