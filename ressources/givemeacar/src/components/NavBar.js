import React from "react";
import {Link} from "react-router-dom"

const listStyle = {
    backgroundColor:'black',
    padding:'1rem'
}

const itemStyle = {
    listStyleType : 'none',
    display:'inline-block',
    paddingLeft:'1rem',
    paddingRight:'1rem',
}

const linkStyle = {
    textDecorationLine:'none',
    color:'white'
}

const NavBar = ({links}) => <ul style={listStyle}>
    {links.map(link=><li style={itemStyle}>
        <Link to={link.url} style={linkStyle}>{link.label}</Link>
    </li>)}
</ul>

export default NavBar