export class Cart{
    cartId?: any;
    paymentStatus?: string;
    date?: Date;
    customer?: Customer;
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