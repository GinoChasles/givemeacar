import React from 'react'


import { useTranslate } from "react-admin";

import {
    NumberInput,
    required,
} from "react-admin";

export default function StreetNumber() {

    const t = useTranslate();

    return <NumberInput label={t('word.number')} source="streetNumber" validate={[
        required(t('error.required'))
    ]} />
}
