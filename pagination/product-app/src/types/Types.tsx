export interface Product {
    id: number;
    name: string;
    quantity: number;
    price: number;
  }
  
  export interface ProductApiResponse {
    recordCount: number;
    response: { content: Product[] } | Product[];
  }
  