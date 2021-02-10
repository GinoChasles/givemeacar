import React from 'react'


import { useTranslate } from "react-admin";

import {
    TextInput,
    required,
} from "react-admin";

const validateRegex = /[0-9]{2,6}/;

export default function Code() {

    const t = useTranslate();

    return <TextInput label={t('word.code')} source="code"

        validate={[
            required(t('error.required')),
        ]}

    />
}
