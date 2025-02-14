import React from "react";
import { Product } from "../../service/product";
import { Box, styled, Typography } from "@mui/material";
import ProductListItem from "./ProductListItem";


const ProductListView = styled(Box)({
    display:"flex",
    flexWrap: "wrap",
    gap: "10px",
});


interface Props {
    products: Product[];
}

const ProductList: React.FC<Props> = ({products}) => {
    return(
        <Box>
            <Typography variant="h4" style={{textAlign: 'center', marginBottom: '15px'}}>List of Products</Typography>
            <ProductListView>
                {products.map((product) => (
                        <ProductListItem key={product.id} product={product}/>
                    ))
                }
            </ProductListView>
        </Box>
    )
}

export default ProductList;