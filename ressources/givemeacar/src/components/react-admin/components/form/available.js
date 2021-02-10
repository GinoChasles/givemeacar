import React from 'react'


import { useTranslate } from "react-admin";

import {
    BooleanInput,
    required,
} from "react-admin";

export default function Color() {

    const t = useTranslate();

    return <BooleanInput label={t('word.available')} source="available" validate={[
        required(t('error.required'))
    ]} />
}
