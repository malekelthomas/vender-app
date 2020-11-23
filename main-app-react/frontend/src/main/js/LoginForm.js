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


const LoginForm = () => {
  const [email, setEmail] = useState("");
  const [pw, setPw] = useState("");
  const handleSubmit = (e) => {
    e.preventDefault();
    console.log(email,pw);
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
          <form id="loginForm" className={classes.root} onSubmit={handleSubmit}>
            <TextField 
              required 
              value={email} 
              label="Email" 
              onChange={(e) => setEmail(e.target.value)}
            />
            <TextField 
              required 
              value={pw} 
              type="password" 
              label="Password" 
              onChange={(e) => setPw(e.target.value)}
            />
          </form>
        </CardContent>
        <CardActions>
          <Button size="small" type="submit" form="loginForm">login</Button>
        </CardActions>
      </Card>
    )
}

export default LoginForm;