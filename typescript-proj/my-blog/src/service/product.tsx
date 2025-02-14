import {faker} from '@faker-js/faker';
import {v4 as uuid} from 'uuid';


export interface Product {
    id: string;
    title: string;
    description: string;
    imageUrl: string;
}

export const getProducts = () => {
    return Array(10).fill(0).map(()=>{
        return {
            id: uuid(),
            title: faker.lorem.text(),
            description: faker.lorem.paragraph(),
            imageUrl: faker.image.avatar(),
        } as Product;
    })
}
