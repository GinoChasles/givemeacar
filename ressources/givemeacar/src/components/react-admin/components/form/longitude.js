import React from 'react'


import { useTranslate } from "react-admin";

import {
    NumberInput,
    required,
} from "react-admin";

export default function Longitude() {

    const t = useTranslate();

    return <NumberInput label={t('word.longitude')} source="longitude" validate={[
        required(t('error.required'))
    ]} />
}
