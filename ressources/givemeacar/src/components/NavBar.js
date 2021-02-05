import React from "react";
import {Link} from "react-router-dom"

const listStyle = {
    backgroundColor:'black',
    padding:'1rem',
    display:'flex',
    flexFlow:'flex-row wrap',
    alignItems:'center',
}

const itemStyle = {
    listStyleType : 'none',
    paddingLeft:'1rem',
    paddingRight:'1rem',
    flex:'auto',
}

const linkStyle = {
    textDecorationLine:'none',
    color:'white'
}

const NavBar = ({ links }, i) => <ul key={i} id="main-navbar" style={listStyle}>
    {links.map((link, i) => <li key={i} style={itemStyle}>
        <Link to={link.url} style={linkStyle}>{link.label}</Link>
    </li>)}
</ul>

export default NavBar