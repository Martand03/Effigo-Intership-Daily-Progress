/* eslint-disable @typescript-eslint/no-empty-object-type */
import React from 'react';
import { Box } from '@mui/material';
import Layout from './components';
import ProductList from './components/product/ProductList';
import { getProducts } from './service/product';

const App: React.FC<{}> = () => {
  return(
    <Box>
      <Layout>
       <ProductList products={getProducts()}/>
      </Layout>
    </Box>
  )
}

export default App;
