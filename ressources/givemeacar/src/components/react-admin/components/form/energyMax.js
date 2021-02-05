import React from 'react'


import { useTranslate } from "react-admin";

import {
    NumberInput,
    required,
} from "react-admin";

export default function Kilometer() {

    const t = useTranslate();

    return <NumberInput label={t('word.energyMax')} source="energy_max" validate={[
        required(t('error.required'))
    ]} />
}
