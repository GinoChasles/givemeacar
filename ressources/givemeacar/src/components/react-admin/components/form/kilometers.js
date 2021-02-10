import React from 'react'


import { useTranslate } from "react-admin";

import {
    NumberInput,
    required,
} from "react-admin";

export default function Kilometer() {

    const t = useTranslate();

    return <NumberInput label={t('word.kilometers')} source="kilometers" validate={[
        required(t('error.required'))
    ]} />
}
