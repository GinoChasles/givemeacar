import React from 'react'


import { useTranslate } from "react-admin";

import {
    NumberInput,
    required,
} from "react-admin";

export default function Price() {

    const t = useTranslate();

    return <NumberInput label={t('word.price')} source="price" validate={[
        required(t('error.required'))
    ]} />
}
