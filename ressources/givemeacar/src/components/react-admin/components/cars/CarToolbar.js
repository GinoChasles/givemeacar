import React from 'react'

import { Toolbar, SaveButton } from 'react-admin';

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