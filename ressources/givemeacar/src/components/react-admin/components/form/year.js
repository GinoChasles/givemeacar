import React from 'react'


import { useTranslate } from "react-admin";

import {
    NumberInput,
    required,
} from "react-admin";

export default function Year() {

    const t = useTranslate();

    return <NumberInput label={t('word.year')} source="year" validate={[
        required(t('error.required'))
    ]} />
}
