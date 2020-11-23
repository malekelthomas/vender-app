import React, { useState }  from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Card from '@material-ui/core/Card';
import CardActions from '@material-ui/core/CardActions';
import CardContent from '@material-ui/core/CardContent';
import Button from '@material-ui/core/Button';
import Typography from '@material-ui/core/Typography';
import { TextField, useMediaQuery } from '@material-ui/core/';
const useStyles = makeStyles((theme) => ({
  root: {
      '& > *': {
        margin: theme.spacing(1),
        width: '25ch',
        display: 'flex',
        flexWrap: 'wrap',
        justifyContent: 'center'
      },
    },
  }));


const NewVendingMachineForm = () => {
  const [location, setLocation] = useState("");
  const handleSubmit = (e) => {
    e.preventDefault();
    console.log(location);
  }
  const classes = useStyles();

    return (
      <Card style={{
        margin: "15em auto",
        display:"flex", 
        justifyContent:"center",
        maxWidth:350,
        backgroundColor:"lightgrey"
        }}>
        <CardContent>
          <form id="newVendingMachineForm" className={classes.root} onSubmit={handleSubmit}>
            <TextField 
              required 
              value={location} 
              label="Location" 
              onChange={(e) => setLocation(e.target.value)}
            />
          </form>
        </CardContent>
        <CardActions>
          <Button size="small" type="submit" form="loginForm">login</Button>
        </CardActions>
      </Card>
    )
}

export default NewVendingMachineForm;