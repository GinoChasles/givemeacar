import React from 'react'


import { useTranslate } from "react-admin";

import {
    BooleanInput,
    required,
} from "react-admin";

export default function Rented() {

    const t = useTranslate();

    return <BooleanInput label={t('word.rented')} source="rented" validate={[
        required(t('error.required'))
    ]} />
}
