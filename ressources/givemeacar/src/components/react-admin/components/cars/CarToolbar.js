import React from 'react'

import { Toolbar, SaveButton } from 'react-admin';

/**
 * Surcharge de la toolbar en bas du formulaire afin de changer les booléens en nombres pour springboot
 */
export default function CarToolbar() {
    return <Toolbar>
        <SaveButton submitOnEnter transform={(data) => {
            data.available = data.available === true ? 1 : 0;
            data.rented = data.rented === true ? 1 : 0;
            console.log(data)
            return data;
        }} />
    </Toolbar>
}