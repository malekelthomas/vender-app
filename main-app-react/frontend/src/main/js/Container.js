import React, { useState, useEffect } from 'react';
import './css/Container.css';
import Product from './Product';
import VendingMachine from './VendingMachine';
import {Route, BrowserRouter as Router, Switch, Link} from 'react-router-dom';
import { AppBar, Menu, MenuItem, Typography } from "@material-ui/core";
import { makeStyles } from '@material-ui/core/styles';
const Container = () => {
    const useStyles = makeStyles((theme) => ({
        root: {
          flexGrow: 1,
        },
        menuButton: {
          marginRight: theme.spacing(2),
        },
        title: {
          flexGrow: 1,
        },
      }));
    
    
    const classes = useStyles();
    return (
        <div className={classes.root}>
            <Router>
                <AppBar>
                    <MenuItem>
                        <Link to="/vendingmachines/">
                            <Typography className={classes.title} variant="h6" noWrap>Vending Machines</Typography>
                        </Link>
                    </MenuItem>
                    <MenuItem>
                        <Link to="/vendingmachines/1">
                            <Typography className={classes.title} variant="h6" noWrap>Vending Machine 1</Typography>
                        </Link>
                    </MenuItem>
                </AppBar>
            
                <Switch>
                    <Route path="/vendingmachines/:id?" component={VendingMachine}></Route>
                    <Route path="/products/:id?" component={Product}></Route>
                </Switch>
            </Router>
        </div>
    )
}

export default Container;