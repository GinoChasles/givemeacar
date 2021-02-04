import {
    Datagrid, Filter, List, SearchInput, TextField, useTranslate
} from "react-admin";
import * as React from "react";

const PostFilter = (props) => (
    <Filter {...props}>
        <SearchInput source="q" alwaysOn />
    </Filter>
);

const DisplayStatus = (props) => {

    const t = useTranslate();

    return <List {...props} title={t('word.statuses')} filters={<PostFilter />}>
        <Datagrid rowClick="edit">
            <TextField label={t('word.id')} source="id" />

            <TextField label={t('word.name')} source="name" />
        </Datagrid>
    </List>
}

export default DisplayStatus