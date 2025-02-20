import { useEffect, useState } from 'react';
import { getPaginatedProducts } from '../services/productService';
import { Product } from '../types/Types';
import { Table, TableBody, TableCell, TableHead, TableRow, TableContainer, Paper, Pagination } from '@mui/material';

const ProductTable = () => {
  const [products, setProducts] = useState<Product[]>([]);
  const [page, setPage] = useState(0);
  const [totalPages, setTotalPages] = useState(20);

  useEffect(() => {
    const fetchData = async () => {
      const data = await getPaginatedProducts(page, 10);
      setProducts(data);
    };
    fetchData();
  }, [page]);

  const handleChangePage = (_event: React.ChangeEvent<unknown>, value: number) => {
    setPage(value - 1);
  };

  return (
    <div style={{ width: '95vw', boxSizing: 'border-box' }}>
      <TableContainer component={Paper}>
        <Table>
          <TableHead style={{ backgroundColor: '#2196f3' }}>
            <TableRow>
              <TableCell style={{ color: 'white' }}>ID</TableCell>
              <TableCell style={{ color: 'white' }}>Name</TableCell>
              <TableCell style={{ color: 'white' }}>Quantity</TableCell>
              <TableCell style={{ color: 'white' }}>Price</TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {products.map((product, index) => (
              <TableRow key={product.id}
                style={{
                    backgroundColor: index % 2 === 0 ? '#d1c7c5' : 'white',
                }}
              >
                <TableCell>{product.id}</TableCell>
                <TableCell>{product.name}</TableCell>
                <TableCell>{product.quantity}</TableCell>
                <TableCell>{product.price}</TableCell>
              </TableRow>
            ))}
          </TableBody>
        </Table>
      </TableContainer>

      <Pagination
        count={totalPages}
        page={page + 1}
        onChange={handleChangePage}
        color="primary"
        sx={{
            marginTop: 2,
            display: 'flex',
            justifyContent: 'center',
            '& .MuiPaginationItem-root': {
              color: 'white', 
            },
            '& .Mui-selected': {
              backgroundColor: 'white',
              color: 'black',
            },
        }}
      />
    </div>
  );
};

export default ProductTable;
