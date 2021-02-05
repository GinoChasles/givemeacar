import React from 'react'


import { useTranslate } from "react-admin";

import {
    NumberInput,
    required,
} from "react-admin";

export default function Kilometer() {

    const t = useTranslate();

    return <NumberInput label={t('word.energyMax')} source="energyMax" validate={[
        required(t('error.required'))
    ]} />
}
