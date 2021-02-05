import React from 'react'


import { useTranslate } from "react-admin";

import {
    TextInput,
    required,
    regex,
    minLength,
    maxLength
} from "react-admin";

const validateRegex = /\+?[0-9]{10,12}/;

export default function Phone() {

    const t = useTranslate();

    return <TextInput source="phone" label={t('word.phone')}
        validate={[
            required(t('error.required')),
            regex(validateRegex, t('error.regex')),
            minLength(6),
            maxLength(64),
        ]}

    />
}
