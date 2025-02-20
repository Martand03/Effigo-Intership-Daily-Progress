import axios from 'axios';
import { ProductApiResponse, Product } from '../types/Types';

const API_BASE_URL = 'http://localhost:8085/products';

export const getAllProducts = async () => {
  const response = await axios.get<ProductApiResponse>(`${API_BASE_URL}`);
  return response.data.response as Product[];
};

export const getProductsWithZeroQuantity = async () => {
  const response = await axios.get<ProductApiResponse>(`${API_BASE_URL}/quantity`);
  return response.data.response as Product[];
};

export const getPaginatedProducts = async (page: number, size: number) => {
  const response = await axios.get<ProductApiResponse>(`${API_BASE_URL}/pagination/${page}/${size}`);
  return (response.data.response as { content: Product[] }).content;
};
