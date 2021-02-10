import React from 'react'


import { useTranslate } from "react-admin";

import {
    NumberInput,
    required,
} from "react-admin";

export default function Latitude() {

    const t = useTranslate();

    return <NumberInput label={t('word.latitude')} source="latitude" validate={[
        required(t('error.required'))
    ]} />
}
