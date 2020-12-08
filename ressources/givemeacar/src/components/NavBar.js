import React from "react";
import {Link} from "react-router-dom"

const NavBar = ({links}) => <ul>{links.map(link=><li><Link to={link.url}>{link.label}</Link></li>)}</ul>

export default NavBar