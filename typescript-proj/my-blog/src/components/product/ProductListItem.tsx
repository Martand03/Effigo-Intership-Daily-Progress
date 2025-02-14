import React from 'react'
import Card from '@mui/material/Card';
import CardActions from '@mui/material/CardActions';
import CardContent from '@mui/material/CardContent';
import CardMedia from '@mui/material/CardMedia';
import Button from '@mui/material/Button';
import Typography from '@mui/material/Typography';

import { Product } from '../../service/product'
import { Box, styled } from '@mui/material';


const ProductListItemView = styled(Box)({})


interface Props {
    product: Product;
}
const ProductListItem: React.FC<Props> = ({product}) => {
    return (
        <ProductListItemView>
          <Card sx={{ maxWidth: 400 }}>
            <CardMedia
              sx={{ height: 330 }}
              image={`${product.imageUrl}`}
            />
            <CardContent>
              <Typography gutterBottom variant="h5" component="div">
                {product.title}
              </Typography>
              <Typography variant="body2" sx={{ color: 'text.secondary' }}>
                {product.description}
              </Typography>
            </CardContent>
            <CardActions>
              <Button size="small">Share</Button>
            </CardActions>
          </Card>
        </ProductListItemView>
      );
}

export default ProductListItem