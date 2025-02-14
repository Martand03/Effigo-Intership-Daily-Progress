import { Box } from "@mui/material";
import Header from "./Header";
import React, { ReactElement } from "react";

interface Props {
    children : ReactElement;
}

const Layout: React.FC<Props> = ({children}) => {
  return (
    <Box>
        <Header />
        <Box marginTop={5}>{children}</Box>
    </Box>
  )
}

export default Layout;